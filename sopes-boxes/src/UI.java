import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;


public class UI {
    // frame
    static int filledSlots = 0;
    static int emptySlots = 20;
    static int smallBoxesPutCount = 0;
    static int smallBoxesPickCount = 0;
    static int bigBoxesPutCount = 0;
    static int bigBoxesPickCount = 0;

    static int putBoxTimingSmall = 2;
    static int pickBoxTimingSmall = 100;
    static int putBoxTimingBig = 100;
    static int pickBoxTimingBig = 100;
    static ScheduledFuture<?> futurePickBoxSmall;
    static ScheduledFuture<?> futurePutBoxSmall;
    static ScheduledFuture<?> futurePickBoxBig;
    static ScheduledFuture<?> futurePutBoxBig;
    static JLabel counters = new JLabel();

    static LinkedList<Box> putBigBoxesQueue = new LinkedList<>();
    static LinkedList<Box> putSmallBoxesQueue = new LinkedList<>();
    static LinkedList<Integer> pickBigBoxesQueue = new LinkedList<>();
    static LinkedList<Integer> pickSmallBoxesQueue = new LinkedList<>();


    static void countersText() {
        StringBuilder st = new StringBuilder("");

        st.append("<html><body>");
        st.append("Filled Slots: " + filledSlots);
        st.append("<br>");
        st.append("Empty Slots: " + emptySlots);
        st.append("<br>");
        st.append("Small Box Put: " + smallBoxesPutCount);
        st.append("<br>");
        st.append("Small Box Pick: " + smallBoxesPickCount);
        st.append("<br>");
        st.append("Big Box Put: " + bigBoxesPutCount);
        st.append("<br>");
        st.append("Big Box Pick: " + bigBoxesPickCount);
        st.append("<br>");
        st.append("<br>");
        st.append("<br>");
        st.append("Small Box Put Queue: " + putSmallBoxesQueue.size());
        st.append("<br>");
        st.append("Small Box Pick Queue: " + pickSmallBoxesQueue.size());
        st.append("<br>");
        st.append("Big Box Put Queue: " + putBigBoxesQueue.size());
        st.append("<br>");
        st.append("Big Box Pick Queue: " + pickBigBoxesQueue.size());
        st.append("</body></html>");

        counters.setText(st.toString());
    }

    static void updatePickCounters(int size) {
        switch (size) {
            case Sizes.Big:
                if(filledSlots > 0) {
                    filledSlots--;
                    filledSlots--;
                }
                if(emptySlots<20) {
                    emptySlots++;
                    emptySlots++;
                }

                bigBoxesPickCount++;
                break;
            case Sizes.Small:
                if(filledSlots > 0)
                filledSlots--;
                if(emptySlots<20)
                emptySlots++;
                smallBoxesPickCount++;
                break;
            default:
                break;
        }
        countersText();
    }

    static void updatePutCounters(int size) {
        switch (size) {
            case Sizes.Big:
                if(filledSlots<20) {
                    filledSlots++;
                    filledSlots++;
                }
                if(emptySlots>0) {
                    emptySlots--;
                    emptySlots--;
                }

                bigBoxesPutCount++;
                break;
            case Sizes.Small:
                if(filledSlots<20)
                filledSlots++;
                if(emptySlots>0)
                emptySlots--;
                smallBoxesPutCount++;
                break;
            default:
                break;
        }
        countersText();
    }


    static ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

    static ScheduledFuture<?> changeTaskTiming(int time, ScheduledFuture<?> futureTask, Runnable task) {
        if(futureTask != null)
            futureTask.cancel(true);
        return executor.scheduleAtFixedRate(task, 0, time, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {

        countersText();

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        Rack rack = new Rack();

        rack.repaint();

        rack.setPreferredSize(new Dimension(500, 500));
        rack.setBackground(Color.green);
        rack.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        frame.getContentPane().add(rack);

        Runnable pickBoxSmall = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World from pick box small");
                if(rack.pickBox(Sizes.Small) == 0){
                    if (putSmallBoxesQueue.size() > 0) {
                        rack.putBox(new Box(Sizes.Small));
                        putSmallBoxesQueue.pop();
                        updatePickCounters(Sizes.Small);
                    }
                }else{
                    pickSmallBoxesQueue.push(0);
                };
                updatePickCounters(Sizes.Small);
            }
        };

        Runnable putBoxSmall = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World from put box small");
                if(rack.putBox(new Box(Sizes.Small)) == 0){
                    if (pickSmallBoxesQueue.size() > 0) {
                        pickBoxSmall.run();
                        pickSmallBoxesQueue.pop();
                    }
                }else{
                    putSmallBoxesQueue.push(new Box(Sizes.Small));
                };
                updatePutCounters(Sizes.Small);
            }
        };

        Runnable pickBoxBig = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World from pick box big");
                if(rack.pickBox(Sizes.Big) == 0){
                    if (putBigBoxesQueue.size() > 0) {
                        rack.putBox(new Box(Sizes.Big));
                        putBigBoxesQueue.pop();
                        updatePickCounters(Sizes.Big);
                    }
                }else{
                    pickBigBoxesQueue.push(0);
                };
                updatePickCounters(Sizes.Big);
            }
        };

        Runnable putBoxBig = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World from put box big");
                if(rack.putBox(new Box(Sizes.Big)) == 0){
                    if (pickBigBoxesQueue.size() > 0) {
                        pickBoxBig.run();
                        pickBigBoxesQueue.pop();
                    }
                }else{
                    putBigBoxesQueue.push(new Box(Sizes.Big));
                };
                updatePickCounters(Sizes.Big);
            }
        };


        futurePickBoxSmall = executor.scheduleAtFixedRate(pickBoxSmall, 0, pickBoxTimingSmall, TimeUnit.SECONDS);
        futurePutBoxSmall = executor.scheduleAtFixedRate(putBoxSmall, 0, putBoxTimingSmall, TimeUnit.SECONDS);
        futurePickBoxBig = executor.scheduleAtFixedRate(pickBoxBig, 0, pickBoxTimingBig, TimeUnit.SECONDS);
        futurePutBoxBig = executor.scheduleAtFixedRate(putBoxBig, 0, putBoxTimingBig, TimeUnit.SECONDS);



        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.white);
        northPanel.setForeground(Color.BLACK);
        northPanel.setPreferredSize(new Dimension(0, 150));
        frame.getContentPane().add(northPanel, BorderLayout.NORTH);

        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.white);
        westPanel.setPreferredSize(new Dimension(300, 0));

        counters.setPreferredSize(new Dimension(200, 500));
        westPanel.add(counters);

        frame.getContentPane().add(westPanel, BorderLayout.WEST);


        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.white);
        southPanel.setPreferredSize(new Dimension(0, 150));
        frame.getContentPane().add(southPanel, BorderLayout.SOUTH);

        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(Color.white);
        eastPanel.setPreferredSize(new Dimension(300, 0));


        JSlider sliderPutBoxSmall = new JSlider(JSlider.HORIZONTAL, 0, 100, putBoxTimingSmall);
        sliderPutBoxSmall.setMinorTickSpacing(1);
        sliderPutBoxSmall.setMajorTickSpacing(10);
        sliderPutBoxSmall.setPaintTicks(true);
        sliderPutBoxSmall.setPaintLabels(true);
        sliderPutBoxSmall.setLabelTable(sliderPutBoxSmall.createStandardLabels(10));
        eastPanel.add(sliderPutBoxSmall, BorderLayout.CENTER);


        JButton btn1 = new JButton("Change Put Box Timing Small");
        eastPanel.add(btn1);
        btn1.addActionListener(e -> {
            putBoxTimingSmall = sliderPutBoxSmall.getValue();
            futurePutBoxSmall = changeTaskTiming(putBoxTimingSmall, futurePutBoxSmall, putBoxSmall);
            btn1.setText("Change Put Box Timing Small (" + putBoxTimingSmall+")");
        });



        JSlider sliderPickBoxSmall = new JSlider(JSlider.HORIZONTAL, 0, 100, pickBoxTimingSmall);
        sliderPickBoxSmall.setMinorTickSpacing(1);
        sliderPickBoxSmall.setMajorTickSpacing(10);
        sliderPickBoxSmall.setPaintTicks(true);
        sliderPickBoxSmall.setPaintLabels(true);
        sliderPickBoxSmall.setLabelTable(sliderPickBoxSmall.createStandardLabels(10));
        eastPanel.add(sliderPickBoxSmall, BorderLayout.CENTER);

        JButton btn2 = new JButton("Change Pick Box Timing Small");
        eastPanel.add(btn2);
        btn2.addActionListener(e -> {
            pickBoxTimingSmall = sliderPickBoxSmall.getValue();
            futurePickBoxSmall = changeTaskTiming(pickBoxTimingSmall, futurePickBoxSmall, pickBoxSmall);
            btn2.setText("Change Pick Box Timing Small (" + pickBoxTimingSmall +")");
        });


        JSlider sliderPutBoxBig = new JSlider(JSlider.HORIZONTAL, 0, 100, putBoxTimingBig);
        sliderPutBoxBig.setMinorTickSpacing(1);
        sliderPutBoxBig.setMajorTickSpacing(10);
        sliderPutBoxBig.setPaintTicks(true);
        sliderPutBoxBig.setPaintLabels(true);
        sliderPutBoxBig.setLabelTable(sliderPutBoxBig.createStandardLabels(10));
        eastPanel.add(sliderPutBoxBig, BorderLayout.CENTER);

        JButton btn3 = new JButton("Change Put Box Timing Big");
        eastPanel.add(btn3);
        btn3.addActionListener(e -> {
            putBoxTimingBig = sliderPutBoxBig.getValue();
            futurePutBoxBig = changeTaskTiming(putBoxTimingBig, futurePutBoxBig, putBoxBig);
            btn3.setText("Change Put Box Timing Big (" + putBoxTimingBig+")");
        });


        JSlider sliderPickBoxBig = new JSlider(JSlider.HORIZONTAL, 0, 100, pickBoxTimingBig);
        sliderPickBoxBig.setMinorTickSpacing(1);
        sliderPickBoxBig.setMajorTickSpacing(10);
        sliderPickBoxBig.setPaintTicks(true);
        sliderPickBoxBig.setPaintLabels(true);
        sliderPickBoxBig.setLabelTable(sliderPickBoxBig.createStandardLabels(10));
        eastPanel.add(sliderPickBoxBig, BorderLayout.CENTER);

        JButton btn4 = new JButton("Change Pick Box Timing Big");
        eastPanel.add(btn4);
        btn4.addActionListener(e -> {
            pickBoxTimingBig = sliderPickBoxBig.getValue();
            futurePickBoxBig = changeTaskTiming(pickBoxTimingBig, futurePickBoxBig, pickBoxBig);
            btn4.setText("Change Pick Box Timing Big (" + pickBoxTimingBig+")");
        });

        frame.getContentPane().add(eastPanel, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);



    }
}