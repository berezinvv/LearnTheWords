package com.learnthewords.swing;

import com.fasterxml.jackson.databind.ObjectMapper;
import json.Leo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Form implements ActionListener {

    JFrame form;
    JTabbedPane tp;
    JPanel panelMain, panelTools;
    JButton buttonGetFrom_bd, buttonGetWord_bd;
    JTextField textURLGetRandomWord, textURLGetJsonWord;
    JLabel textOutURLGetRandomWord, textOutURLGetJsonWord, textOutWord, textOutWordTranslate, iconLabel;
    JTextArea areaResponse;

    Form() {
        form = new JFrame("Learn the words");
        form.setSize(500, 500);

        panelMain = new JPanel();
        panelTools = new JPanel();
        tp = new JTabbedPane();
        tp.setBounds(0, 0, 450, 450);


        textOutURLGetRandomWord = new JLabel("URL get random word from db:");
        textOutURLGetRandomWord.setBounds(10, 20, 100, 20);

        textURLGetRandomWord = new JTextField("http://localhost:8080/demo/getRandomWord");
        textURLGetRandomWord.setBounds(110, 20, 100, 20);

        buttonGetFrom_bd = new JButton("Get from db");
        buttonGetFrom_bd.setBounds(10, 50, 50, 20);
        buttonGetFrom_bd.addActionListener(this);

        textOutURLGetJsonWord = new JLabel("URL get word:");
        textOutURLGetRandomWord.setBounds(10, 80, 100, 20);

        textURLGetJsonWord = new JTextField("http://localhost:8080/demo/getJsonWord");
        textURLGetJsonWord.setBounds(110, 80, 100, 20);

        buttonGetWord_bd = new JButton("Get word");
        buttonGetFrom_bd.setBounds(10, 110, 50, 20);
        buttonGetWord_bd.addActionListener(this);

        areaResponse = new JTextArea("text");
        areaResponse.setBounds(10, 130, 200, 200);

        panelTools.add(textOutURLGetRandomWord);
        panelTools.add(textURLGetRandomWord);


        panelTools.add(textOutURLGetJsonWord);
        panelTools.add(textURLGetJsonWord);

        panelTools.add(buttonGetWord_bd);
        panelTools.add(buttonGetFrom_bd);

        panelTools.add(areaResponse);

        textOutWord = new JLabel();
        textOutWordTranslate = new JLabel();
        iconLabel = new JLabel();

        panelMain.add(buttonGetWord_bd);
        panelMain.add(textOutWord);
        panelMain.add(textOutWordTranslate);
        panelMain.add(iconLabel);


        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tp.add("main", panelMain);
        tp.add("tools", panelTools);
        //form.add(panelMain);
        //form.add(panelTools);

        form.add(tp);

        //Container con = form.getContentPane();
        //con.add(tp);

        form.setLayout(null);
        form.setVisible(true);
    }


    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == buttonGetFrom_bd) {
            String response = getRandomWord();
            areaResponse.setText(response);
            form.setVisible(true);

        } else if (source == buttonGetWord_bd) {
            ObjectMapper objectMapper = new ObjectMapper();
            URL url_pic = null;
            Image image = null;
            Leo leo = new Leo();
            String response = getJsonWord();
            areaResponse.setText(response);

            try {
                leo = objectMapper.readValue(response, Leo.class);
                url_pic = new URL(leo.getPic_url());
                image = ImageIO.read(url_pic);
            } catch (IOException e) {
                e.printStackTrace();
            }

            textOutWord.setText(leo.getWord_forms().get(0).getWord());
            textOutWordTranslate.setText(leo.getTranslate().get(0).getValue());


            iconLabel.setIcon(new ImageIcon(image));

            form.setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Form();
    }

    public String getRandomWord() {
        return getResponseURL(textURLGetRandomWord.getText());
    }

    public String getJsonWord() {
        return getResponseURL(textURLGetJsonWord.getText());
    }

    public String getResponseURL(String textURL) {
        StringBuffer response = new StringBuffer();
        try {
            URL obj = new URL(textURL);

            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

}
