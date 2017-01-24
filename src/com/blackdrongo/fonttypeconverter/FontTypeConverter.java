/*
    FontTypeConverter - A simple tool to convert text in Unicode Malayalam font to Karthika font.
    Copyright (C) 2016  BlackDrongo

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.blackdrongo.fonttypeconverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * created by WeirdElfB0y of BlackDrongo on 22-Aug-2016.
 * last updated on 22-Jan-2017
 */
public class FontTypeConverter implements ActionListener, MouseListener {
    private JFrame jFrame;
    private JTextArea jInputTextArea, jOutputTextArea;
    private JButton jUpdateDataButton, jConvertButton, jCopyOutputButton, jSaveOutputButton;
    private JMenuItem menuNew, menuOpen, menuSave;
    private JMenuItem menuHowto;
    private JComboBox<Font> inputTextFontList, outputTextFontList;
    private Font inputFont, outputFont;
    private CharacterReplacer characterReplacer;
    private String rawText = "";
    private Font defaultFont;
    private JFileChooser jFileChooser;

    private FontTypeConverter() {
        String cwd = System.getProperty("user.dir");
        // FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Text Files(.txt)", "txt", "text");
        jFileChooser = new JFileChooser(cwd);
        // jFileChooser.setFileFilter(fileFilter);

        characterReplacer = new CharacterReplacer();
        defaultFont = new Font("DejaVu Sans", Font.PLAIN, 14); // Arial

        jFrame = new JFrame("Malayalam Font Converter v1.0");
        jFrame.setSize(1300, 700);
        jFrame.setResizable(false);

        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setBounds(0, 0, jFrame.getWidth(), 20);

        menuNew = new JMenuItem("New");
        menuOpen = new JMenuItem("Open");
        menuSave = new JMenuItem("Save");

        menuHowto = new JMenuItem("How to use?");

        menuNew.addActionListener(this);
        menuOpen.addActionListener(this);
        menuSave.addActionListener(this);

        menuHowto.addActionListener(this);

        JMenu menuFile = new JMenu("File");
        JMenu menuHelp = new JMenu("Help");

        menuFile.add(menuNew);
        menuFile.add(menuOpen);
        menuFile.add(menuSave);
        menuHelp.add(menuHowto);

        jMenuBar.add(menuFile);
        jMenuBar.add(menuHelp);
        jFrame.add(jMenuBar);

        JLabel inputLabel = new JLabel("Input:");
        inputLabel.setBounds(20, 30, 100, 20);

        JLabel hintLabel = new JLabel("**Ctrl + Click to place cursor**");
        hintLabel.setBounds(100, 30, 250, 20);

        JLabel outputLabel = new JLabel("Output:");
        outputLabel.setBounds(jFrame.getWidth() / 2, 30, 100, 20);

        jFrame.add(inputLabel);
        jFrame.add(hintLabel);
        jFrame.add(outputLabel);

        inputTextFontList = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts());
        inputTextFontList.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    Font name = (Font) value;
                    value = name.getFontName();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        inputTextFontList.setBounds(jFrame.getWidth() / 2 - 250, 25, 200, 20);
        inputTextFontList.addActionListener(this);
//        inputTextFontList.setSelectedIndex(20); // index of Anjali OldLipi 20 - 239
        inputFont = inputTextFontList.getItemAt(0);

        outputTextFontList = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts());
        outputTextFontList.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    Font name = (Font) value;
                    value = name.getFontName();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        outputTextFontList.setBounds(jFrame.getWidth() - 250, 25, 200, 20);
        outputTextFontList.addActionListener(this);
//        outputTextFontList.setSelectedIndex(153); // index of FML-Karthika 153 - 43
        outputFont = outputTextFontList.getItemAt(0);

        jFrame.add(inputTextFontList);
        jFrame.add(outputTextFontList);

        jInputTextArea = new JTextArea();
        jInputTextArea.setBackground(Color.white);
        jInputTextArea.setForeground(Color.black);
        jInputTextArea.setLineWrap(true);
        jInputTextArea.setWrapStyleWord(true);
        jInputTextArea.addMouseListener(this);

        JScrollPane jInputScroll = new JScrollPane(jInputTextArea);
        jInputScroll.setBounds(20, 50, jFrame.getWidth()/2 - 30, jFrame.getHeight() - 150);
        jInputScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jFrame.getContentPane().add(jInputScroll);

        jOutputTextArea = new JTextArea();
        jOutputTextArea.setBackground(Color.lightGray);
        jOutputTextArea.setForeground(Color.black);
        jOutputTextArea.setEditable(false);
        jOutputTextArea.setLineWrap(true);
        jOutputTextArea.setWrapStyleWord(true);
        jOutputTextArea.addMouseListener(this);

        JScrollPane jOutputScroll = new JScrollPane(jOutputTextArea);
        jOutputScroll.setBounds(jFrame.getWidth() / 2, 50, jFrame.getWidth() / 2 - 30, jFrame.getHeight() - 150);
        jOutputScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jFrame.getContentPane().add(jOutputScroll);

        jUpdateDataButton = new JButton("Update Data");
        jUpdateDataButton.addActionListener(this);
        jUpdateDataButton.setBounds(100, jFrame.getHeight() - 80, 130, 30);
        jFrame.add(jUpdateDataButton);

        jConvertButton = new JButton("Convert");
        jConvertButton.addActionListener(this);
        jConvertButton.setBounds(jFrame.getWidth() / 2 - 130 - 100, jFrame.getHeight() - 80, 130, 30);
        jFrame.add(jConvertButton);

        jCopyOutputButton = new JButton("Copy Output");
        jCopyOutputButton.addActionListener(this);
        jCopyOutputButton.setBounds(jFrame.getWidth() / 2 + 200, jFrame.getHeight() - 80, 130, 30);
        jFrame.add(jCopyOutputButton);

        jSaveOutputButton = new JButton("Save");
        jSaveOutputButton.addActionListener(this);
        jSaveOutputButton.setBounds(jFrame.getWidth()/2 + 400, jFrame.getHeight() - 80, 130, 30);
        jFrame.add(jSaveOutputButton);

        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FontTypeConverter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(menuNew)) {
            System.out.println("New");
            jInputTextArea.setText("");
            jOutputTextArea.setText("");
        }
        if (e.getSource().equals(menuOpen)) {
            System.out.println("Open");
            if(jFileChooser.showOpenDialog(jFrame) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            // reading from file
            File inputFile = jFileChooser.getSelectedFile();
            try {
                InputStreamReader fileReader = new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8);
                jInputTextArea.setFont(defaultFont);
                jInputTextArea.read(fileReader, null);
                fileReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource().equals(menuSave)) {
            System.out.println("Save");
            if(jFileChooser.showSaveDialog(jFrame) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            // writing to file
            File outputFile = jFileChooser.getSelectedFile();
            String filePath = outputFile.getAbsolutePath();
            if(!filePath.endsWith(".txt")) {
                if(filePath.indexOf('.') != -1) {
                    filePath = filePath.substring(0, filePath.lastIndexOf('.'));
                }
                outputFile = new File(filePath + ".txt");
            }
            try {
                OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8);
                jOutputTextArea.write(fileWriter);
                fileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource().equals(menuHowto)) {
            System.out.println("How to");
            String message = "How to input text?\n----------\n" +
                    "# Paste data into the input field using Ctrl+V, or\n" +
                    "# Open a file using File >> Open\n\n" +
                    "How to convert?\n----------\n" +
                    "1. Enter data using above method\n" +
                    "2. Select the input and output fonts\n" +
                    "3. Click \"Update Data\" button\n" +
                    "4. Click \"Convert\" button\n" +
                    "5. Save the output file using File >> Save\n" +
                    "6. You can also copy text from output field or click \"Copy Output\" button\n";
            JOptionPane.showMessageDialog(jFrame, message, "How to use this?", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource().equals(inputTextFontList)) {
            inputFont = (Font) inputTextFontList.getSelectedItem();
            inputFont = new Font(inputFont.getFamily(), Font.PLAIN, 16);
        }
        if (e.getSource().equals(outputTextFontList)) {
            outputFont = (Font) outputTextFontList.getSelectedItem();
            outputFont = new Font(outputFont.getFamily(), Font.PLAIN, 18);
            if (jOutputTextArea != null && jInputTextArea != null) {
                jOutputTextArea.setFont(outputFont);
            }
        }

        if (e.getSource().equals(jUpdateDataButton)) {
            jInputTextArea.setFont(defaultFont);
            rawText = jInputTextArea.getText();
            String processedInputText = rawText;
            int index = processedInputText.indexOf("റ്റ");
            if(index > 1) {
                String issueString = processedInputText.substring(index - 2, index + 2);
                processedInputText = processedInputText.replace(issueString, issueString.substring(0, 2) + "\u200Cറ്");
                jInputTextArea.setText(processedInputText);
            }
            jInputTextArea.setFont(inputFont);
        }

        if (e.getSource().equals(jConvertButton)) {
            String inputText = jInputTextArea.getText();
            jOutputTextArea.setText(characterReplacer.replaceAll(inputText));
        }

        if (e.getSource().equals(jCopyOutputButton)) {
            jOutputTextArea.selectAll();
            jOutputTextArea.copy();
        }

        if(e.getSource().equals(jSaveOutputButton)) {
            System.out.println("Save");
            if(jFileChooser.showSaveDialog(jFrame) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            // writing to file
            File outputFile = jFileChooser.getSelectedFile();
            String filePath = outputFile.getAbsolutePath();
            if(!filePath.endsWith(".txt")) {
                if(filePath.indexOf('.') != -1) {
                    filePath = filePath.substring(0, filePath.lastIndexOf('.'));
                }
                outputFile = new File(filePath + ".txt");
            }
            try {
                OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8);
                jOutputTextArea.write(fileWriter);
                fileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(jInputTextArea)) {
            if(!e.isControlDown()) {
                jInputTextArea.setFont(defaultFont);
                jInputTextArea.setText(rawText);
            }
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
}
