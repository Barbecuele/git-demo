package TCPTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TestSocketClient extends JFrame {
        private PrintWriter writer;
        private BufferedReader reader;
        private Socket socket;
        private JTextArea ta_info;
        private JTextField tf_send;
        private void connect(){
                ta_info.append("尝试连接······\n");
                try{
                        socket = new Socket("10.3.78.24",2423);
                        while(true){
                                writer = new PrintWriter(socket.getOutputStream(),true);
                                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                ta_info.append("完成连接。\n");
                                getServerInfo();
                        }
                }catch (Exception e){
                        e.printStackTrace();
                }
        }

        public static void main(String[] args) {
                TestSocketClient clien = new TestSocketClient();
                clien.setVisible(true);
                clien.connect();
        }
        private void getServerInfo(){
                try{
                        while(true){
                                if(reader !=null){
                                        String line = reader.readLine();
                                        if(line !=null)
                                                ta_info.append("接受到服务器发送的信息："+line+"\n");
                                }
                        }
                }catch (Exception e){
                        e.printStackTrace();
                }finally {
                        try{
                                if (reader != null){
                                        reader.close();
                                }
                                if(socket !=null){
                                        socket.close();
                                }
                        }catch (IOException e){
                                e.printStackTrace();
                        }
                }
        }
        public TestSocketClient(){
                super();
                setTitle("客户端程序");
                setBounds(100,100,361,257);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                final JPanel panel = new JPanel();
                getContentPane().add(panel, BorderLayout.NORTH);
                final JLabel label = new JLabel();
                label.setForeground(new Color(0,0,255));
                label.setFont(new Font("",Font.BOLD,22));
                label.setText("一对一通信——客户端系统程序");
                panel.add(label);
                final JPanel panel_1 = new JPanel();
                getContentPane().add(panel_1,BorderLayout.SOUTH);
                final JLabel label_1 = new JLabel();
                label_1.setText("客户发送的信息：");
                panel_1.add(label_1);
                tf_send = new JTextField();
                tf_send.setPreferredSize(new Dimension(140,25));
                panel_1.add(tf_send);
                final JButton button = new JButton();
                button.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                writer.println(tf_send.getText());
                                ta_info.append("客户发送的信息是："+tf_send.getText()+"\n");
                                tf_send.setText("");
                        }
                });
                button.setText("发送");
                panel_1.add(button);
                final JScrollPane scrollPane = new JScrollPane();
                getContentPane().add(scrollPane,BorderLayout.CENTER);
                ta_info = new JTextArea();
                scrollPane.setViewportView(ta_info);
        }
}
