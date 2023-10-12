package src.main.java.com.boneless.virus;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.IOException;  // Import IOException
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Virus {
    public static void main(String[] args) {
        ImageIcon image = new ImageIcon("src/main/resources/assets/theImage.png");
        ImageIcon icon = new ImageIcon("src/main/resources/assets/icon.png");
        JLabel mainText = new JLabel();
        mainText.setText("KYS (Keep Yourself Safe) :)");
        mainText.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));

        JLabel blank = new JLabel();
        blank.setIcon(image);

        JFrame mainWindow = new JFrame();
        mainWindow.setIconImage(icon.getImage());
        mainWindow.setSize(700, 700);
        mainWindow.setVisible(true);
        mainWindow.add(mainText);
        mainWindow.setResizable(false);
        mainWindow.setTitle(":)");

        mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    File audioFile = new File("src/main/resources/assets/funni.wav");
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e1) {
                    e1.printStackTrace();
                }

                mainWindow.getContentPane().setBackground(null);
                mainWindow.setIconImage(image.getImage());
                mainWindow.setSize(640, 640);
                mainWindow.remove(mainText);
                mainWindow.add(blank);
                mainWindow.setTitle(">:)");
            }
        });
    }
}
