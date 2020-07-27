package per.will.game.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 打地鼠页面
 * Created by will on 2020/7/27.
 */
public class MouseFrame extends JFrame implements MouseListener {

    // 行，列，总数
    private int row = 6;
    private int column = 8;
    private int count = row * column;
    // 存储每个画面
    List<JLabel> labelList = new ArrayList();
    //
    private JPanel mainPanel = new JPanel(new GridLayout(row, column));
    // 图片
    ImageIcon hole = new ImageIcon("./src/main/resources/images/hole.png");
    ImageIcon mouse1 = new ImageIcon("./src/main/resources/images/mouse1.png");
    ImageIcon mouse2 = new ImageIcon("./src/main/resources/images/mouse2.png");
    ImageIcon hit = new ImageIcon("./src/main/resources/images/hit.png");

    /**
     * 打地鼠主页面
     */
    public MouseFrame() {
        // 窗口大小
        this.setSize(800, 600);
        // 把窗口位置设置到屏幕中心
        this.setLocationRelativeTo(null);
        // 关闭窗口时退出程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("打地鼠");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                JLabel holeLabel = new JLabel(hole);
                holeLabel.addMouseListener(this);
                labelList.add(holeLabel);
                mainPanel.add(holeLabel);
            }
        }
        // 地鼠刷新
        new Thread(new MouseThread()).start();

        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    /**
     * 鼠标点击事件
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel holeLabel = (JLabel) e.getSource();
        // 存在地鼠，调用消失事件
        if (holeLabel.getIcon() == mouse2) {
            new Thread(new MouseDisThread(holeLabel)).start();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * 地鼠钻出的事件
     */
    class MouseThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                // 生成随机位置
                int num = new Random().nextInt(count);
                // 此位置如果是空的才进行出现的动作，否则生成新位置
                while (labelList.get(num).getIcon() != hole) {
                    num = new Random().nextInt(count);
                }
                // 地鼠出现的动作
                try {
                    labelList.get(num).setIcon(mouse1);
                    Thread.sleep(100);
                    labelList.get(num).setIcon(mouse2);
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 时间结束还是未点击的装态，设置为消失
                if (labelList.get(num).getIcon() == mouse2) {
                    labelList.get(num).setIcon(hole);
                }
            }
        }
    }

    /**
     * 被打消失
     */
    class MouseDisThread implements Runnable {

        JLabel holeLabel;

        public MouseDisThread(JLabel holeLabel) {
            this.holeLabel = holeLabel;
        }

        @Override
        public void run() {
            holeLabel.setIcon(hit);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } finally {
                holeLabel.setIcon(hole);
            }
        }
    }

}


