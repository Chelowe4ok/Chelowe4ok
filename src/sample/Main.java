package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.io.File;
import java.util.ArrayList;


public class Main extends Application  implements LineListener {

    String word = "РОФВЦ";
    private Label[] arrayLabel = new Label[33];
    private ArrayList<Button> arrayButton = new ArrayList<>();
    private int countWin = 0;
    private MediaPlayer mediaPlayer;
    private boolean playCompleted;
    boolean playSoundOn = true;
    private ToggleSwish sw;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game");

        BorderPane golovnaGame = new BorderPane();
        GridPane root = new GridPane();
        Pane golovnaAnimation = new Pane();
        Pane root1 = new Pane();
        Pane winner = new Pane();
        Pane soundSetting = new Pane();


        root.setHgap(15);
        root.setVgap(15);
        root.setPadding(new Insets(10,10,10,10));

        char [] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            arrayButton.add(new Button(" "));
            arrayButton.get(i).setMinSize(50, 50);
            arrayButton.get(i).setDisable(false);
            root.add(arrayButton.get(i),i,5);
        }

        Label label0 = new Label("А");
        arrayLabel[0] = label0;
        root.add(label0, 0, 0);
        label0.setOnMouseClicked(event -> {

            char [] words1 = label0.getText().toCharArray();

            for(int i = 0; i < words.length;i++){
            if ((words1[0] == words[i])){
                label0.setText("Yes");
                label0.setTextFill(Color.GREEN);
                label0.setFont(Font.font("Times new Roman",FontWeight.BOLD,34));
                break;
            }
            }
            if (!label0.getText().equals("Yes")){
                label0.setText("No");
                label0.setTextFill(Color.RED);
            }

        });

        label0.setOnMouseEntered(event-> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(90),label0);
            scaleTransition.setToX(1.5);
            scaleTransition.setToY(1.5);
            scaleTransition.play();
        });

        label0.setOnMouseExited(event->{
           ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(90),label0);
           scaleTransition.setFromX(1.5);
           scaleTransition.setFromY(1.5);
           scaleTransition.setToX(1);
           scaleTransition.setToY(1);
            scaleTransition.play();
        });



        Label label1 = new Label("Б");
        arrayLabel[1] = label1;
        root.add(label1,1,0);
        Label label2 = new Label("В");
        arrayLabel[2] = label2;
        root.add(label2,2,0);
        Label label3 = new Label("Г");
        arrayLabel[3] = label3;
        root.add(label3,3,0);
        Label label4 = new Label("Ґ");
        arrayLabel[4] = label4;
        root.add(label4, 4, 0);
        Label label5 = new Label("Д");
        arrayLabel[5] = label5;
        root.add(label5,5,0);
        Label label6 = new Label("Е");
        arrayLabel[6] = label6;
        root.add(label6,6,0);

        Label label7 = new Label("Є");
        arrayLabel[7] = label7;
        root.add(label7,0,1);
        Label label8 = new Label("Ж");
        arrayLabel[8] = label8;
        root.add(label8,1,1);
        Label label9 = new Label("З");
        arrayLabel[9] = label9;
        root.add(label9,2,1);
        Label label10 = new Label("И");
        arrayLabel[10] = label10;
        root.add(label10,3,1);
        Label label11 = new Label("І");
        arrayLabel[11] = label11;
        root.add(label11,4,1);
        Label label12 = new Label("Ї");
        arrayLabel[12] = label12;
        root.add(label12,5,1);
        Label label13 = new Label("Й");
        arrayLabel[13] = label13;
        root.add(label13,6,1);

        Label label14 = new Label("К");
        arrayLabel[14] = label14;
        root.add(label14,0,2);
        Label label15 = new Label("Л");
        arrayLabel[15] = label15;
        root.add(label15,1,2);
        Label label16 = new Label("М");
        arrayLabel[16] = label16;
        root.add(label16,2,2);
        Label label17 = new Label("Н");
        arrayLabel[17] = label17;
        root.add(label17,3,2);
        Label label18 = new Label("О");
        arrayLabel[18] = label18;
        root.add(label18,4,2);
        Label label19 = new Label("П");
        arrayLabel[19] = label19;
        root.add(label19,5,2);
        Label label20 = new Label("Р");
        arrayLabel[20] = label20;
        root.add(label20,6,2);

        Label label21 = new Label("С");
        arrayLabel[21] = label21;
        root.add(label21,0,3);
        Label label22 = new Label("Т");
        arrayLabel[22] = label22;
        root.add(label22,1,3);
        Label label23 = new Label("У");
        arrayLabel[23] = label23;
        root.add(label23,2,3);
        Label label24 = new Label("Ф");
        arrayLabel[24] = label24;
        root.add(label24,3,3);
        Label label25 = new Label("Х");
        arrayLabel[25] = label25;
        root.add(label25,4,3);
        Label label26 = new Label("Ц");
        arrayLabel[26] = label26;
        root.add(label26,5,3);
        Label label27 = new Label("Ч");
        arrayLabel[27] = label27;
        root.add(label27,6,3);

        Label label28 = new Label("Ш");
        arrayLabel[28] = label28;
        root.add(label28,0,4);
        Label label29 = new Label("Щ");
        arrayLabel[29] = label29;
        root.add(label29,1,4);
        Label label30 = new Label("Ь");
        arrayLabel[30] = label30;
        root.add(label30,2,4);
        Label label31 = new Label("Ю");
        arrayLabel[31] = label31;
        root.add(label31,3,4);
        Label label32 = new Label("Я");
        arrayLabel[32] = label32;
        root.add(label32,4,4);

        TextArea textArea = new TextArea();
        textArea.setText("It`s textArea and it was be 5 to 7");
        root.add(textArea,0,7,7,7);


        Label winLabel = new Label("You win!!!");
        Button newgame = new Button("На головне меню");
        newgame.getStyleClass().add("newGame");
        winner.getChildren().addAll(winLabel,newgame);
        Scene winners = new Scene(winner,1024,768);
        winner.getStylesheets().add("sample/WinnerStyle.css");





        for (int j = 0; j < 33; j++){
            arrayLabel[j].setFont(Font.font("Times new Roman", FontWeight.BOLD,34));
            arrayLabel[j].setTextFill(Color.AQUA);
            final int finalJ = j;
            arrayLabel[j].setOnMouseClicked(event -> {

                char [] words1 = arrayLabel[finalJ].getText().toCharArray();


                for(int i = 0; i < words.length;i++){

                    if ((words1[0] == words[i])){
                        arrayButton.get(i).setText(arrayLabel[finalJ].getText());
                        arrayButton.get(i).setFont(Font.font("Times new Roman", FontWeight.BOLD,34));
                        arrayButton.get(i).setTextFill(Color.BLUE);
                        arrayButton.get(i).setMinSize(60,60);
                        arrayLabel[finalJ].setText(arrayLabel[finalJ].getText());
                        arrayLabel[finalJ].setTextFill(Color.BLUE);
                        arrayLabel[finalJ].setFont(Font.font("Times new Roman", FontWeight.BOLD, 34));

                        for (int k = 0; k < arrayButton.size(); k++){
                            if (!arrayButton.get(k).getText().equals(" ")){
                                countWin++;

                            }
                        }

                        if (countWin == arrayButton.size()){
                            primaryStage.setScene(winners);
                        }else{
                            countWin=0;
                        }



                    }
                }
                if (!arrayLabel[finalJ].getTextFill().equals(Color.BLUE)){
                    arrayLabel[finalJ].setText(arrayLabel[finalJ].getText());
                    arrayLabel[finalJ].setTextFill(Color.RED);
                }

            });

            arrayLabel[j].setOnMouseEntered(event -> {
                ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(90), arrayLabel[finalJ]);
                scaleTransition.setToX(1.5);
                scaleTransition.setToY(1.5);
                scaleTransition.play();
            });

            arrayLabel[j].setOnMouseExited(event -> {
                ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(90), arrayLabel[finalJ]);
                scaleTransition.setFromX(1.5);
                scaleTransition.setFromY(1.5);
                scaleTransition.setToX(1);
                scaleTransition.setToY(1);
                scaleTransition.play();
            });
        }




        Image image = new Image(getClass().getResourceAsStream("3.jpeg"));
        ImageView img = new ImageView(image);
        img.setFitHeight(768);
        img.setFitWidth(1024);
        root1.getChildren().add(img);


        MenuItem oldGame = new MenuItem("ПРОДОЛЖИТЬ");
        MenuItem newGame = new MenuItem("НОВАЯ ИГРА");
        MenuItem options = new MenuItem("НАСТРОЙКИ");
        MenuItem exitGame = new MenuItem("ВЫХОД");
        SubMenu mainMenu = new SubMenu(
                oldGame,newGame,options,exitGame
        );
        MenuItem sound = new MenuItem("ЗВУК");
        MenuItem video = new MenuItem("ВИДЕО");
        MenuItem optionsBack = new MenuItem("НАЗАД");
        SubMenu optionsMenu = new SubMenu(
                sound,video,optionsBack
        );
        MenuItem NG1 = new MenuItem("ТУРНИР");
        MenuItem NG3 = new MenuItem("2 ИГРОКА");
        MenuItem NG4 = new MenuItem("НАЗАД");
        SubMenu newGameMenu = new SubMenu(
                NG1,NG3,NG4
        );
        MenuBox menuBox = new MenuBox(mainMenu);


       // golovnaAnimation.getChildren().addAll();
        golovnaGame.setLeft(root);
        golovnaGame.setRight(golovnaAnimation);


        Scene scene = new Scene(golovnaGame,1024,768);
        Scene scene1 = new Scene(root1,1024,768);


        oldGame.setOnMouseClicked(event->{
            img.setVisible(false);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Game");
            if (playSoundOn) {
                stopAudio();
                playAdio("/home/chelowe4ok/IdeaProjects/Visilyitsa/src/sample/2.mp3");
            }
        });
        newGame.setOnMouseClicked(event->menuBox.setSubMenu(newGameMenu));
        options.setOnMouseClicked(event->menuBox.setSubMenu(optionsMenu));
        exitGame.setOnMouseClicked(event-> System.exit(0));
        optionsBack.setOnMouseClicked(event->menuBox.setSubMenu(mainMenu));
        NG4.setOnMouseClicked(event-> menuBox.setSubMenu(mainMenu));
        NG1.setOnMouseClicked(event->{
            img.setVisible(false);
            for (int i = 0; i < arrayLabel.length; i++) {
                arrayLabel[i].setTextFill(Color.AQUA);
            }
            for (int i = 0; i < arrayButton.size();i++){
                arrayButton.get(i).setText(" ");
            }
            primaryStage.setScene(scene);
            primaryStage.setTitle("Game");
            if (playSoundOn) {
                stopAudio();
                playAdio("/home/chelowe4ok/IdeaProjects/Visilyitsa/src/sample/2.mp3");
            }

        });


        ToggleButton toggleButton= new ToggleButton("On");
        toggleButton.setTranslateX(549);
        toggleButton.setTranslateY(414);
        toggleButton.getStyleClass().add("soundOn");
        ToggleButton toggleButton1= new ToggleButton("Off");
        toggleButton1.setTranslateX(512);
        toggleButton1.setTranslateY(414);
        toggleButton1.getStyleClass().add("soundOff");
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleButton.setToggleGroup(toggleGroup);
        toggleButton1.setToggleGroup(toggleGroup);

        Label soundLabel = new Label();
        soundLabel.setText("Sound setting");
        soundLabel.setTextFill(Color.YELLOW);
        soundLabel.setTranslateX(400);
        soundLabel.setTranslateY(414);
        Button exitSound = new Button("На головне меню");
        exitSound.setTranslateX(512);
        exitSound.setTranslateY(500);
        exitSound.getStyleClass().add("backButton");

        toggleButton.setOnMouseClicked(event->{

            playSoundOn = true;
//            stopAudio();
            playAdio("/home/chelowe4ok/IdeaProjects/Visilyitsa/src/sample/1.mp3");
//            toggleButton1.getStyleClass().setAll("soundOff1");

        });
        toggleButton1.setOnMouseClicked(event->{

            stopAudio();
            playSoundOn = false;
//            toggleButton.getStyleClass().setAll("soundOn1");


        });

        soundSetting.getChildren().addAll(soundLabel,exitSound,toggleButton,toggleButton1);
        Scene soundProperis = new Scene(soundSetting,1024,768);
        soundSetting.getStylesheets().add("sample/SoundSetting.css");
        sound.setOnMouseClicked(event->{

            primaryStage.setScene(soundProperis);

        });



        exitSound.setOnMouseClicked(event-> {
            FadeTransition ft = new FadeTransition(Duration.seconds(1),menuBox);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.play();
            menuBox.setVisible(true);
            img.setVisible(true);
            primaryStage.setScene(scene1);
            primaryStage.setTitle("Pause");
//            if (playSoundOn) {
//                stopAudio();
//                playAdio("/home/chelowe4ok/IdeaProjects/Visilyitsa/src/sample/1.mp3");
//            }
        });


        root1.getChildren().addAll(menuBox);

        FadeTransition ft1 = new FadeTransition(Duration.seconds(1),menuBox);
        ft1.setFromValue(0);
        ft1.setToValue(1);
        ft1.play();
        menuBox.setVisible(true);

        playAdio("/home/chelowe4ok/IdeaProjects/Visilyitsa/src/sample/1.mp3");


        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                FadeTransition ft = new FadeTransition(Duration.seconds(1),menuBox);
                if (!menuBox.isVisible()) {
                    ft1.stop();
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    menuBox.setVisible(true);
                    img.setVisible(true);
                    primaryStage.setScene(scene1);
                    primaryStage.setTitle("Pause");
                    if (playSoundOn) {
                        stopAudio();
                        playAdio("/home/chelowe4ok/IdeaProjects/Visilyitsa/src/sample/1.mp3");
                    }
                }
                else{
                    ft1.stop();
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt ->   menuBox.setVisible(false));
                    ft.play();
                    img.setVisible(false);
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("Game");
                    if (playSoundOn) {
                        stopAudio();
                        playAdio("/home/chelowe4ok/IdeaProjects/Visilyitsa/src/sample/2.mp3");
                    }
                }
            }
        });

        scene1.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                FadeTransition ft = new FadeTransition(Duration.seconds(1),menuBox);
                if (!menuBox.isVisible()) {
                    ft1.stop();
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    menuBox.setVisible(true);
                    img.setVisible(true);
                    primaryStage.setScene(scene1);
                    //primaryStage.setTitle("Pausa");
                    if (playSoundOn) {
                        stopAudio();
                        playAdio("/home/chelowe4ok/IdeaProjects/Visilyitsa/src/sample/1.mp3");
                    }
                }
                else{
                    ft1.stop();
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt ->   menuBox.setVisible(false));
                    ft.play();
                    img.setVisible(false);
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("Game");
                    if (playSoundOn) {
                        stopAudio();
                        playAdio("/home/chelowe4ok/IdeaProjects/Visilyitsa/src/sample/2.mp3");
                    }

                }
            }
        });

        newgame.setOnMouseClicked(event->{
            img.setVisible(true);
            primaryStage.setScene(scene1);

        });

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Pausa");
        scene.getStylesheets().add("sample/MyStyle.css");
        primaryStage.show();

    }


    private static class MenuItem extends StackPane{
        public  MenuItem(String name){
            Rectangle bg = new Rectangle(200,20,Color.DARKKHAKI);
            bg.setOpacity(0.7);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg,text);
            FillTransition st = new FillTransition(Duration.seconds(0.5),bg);
            setOnMouseEntered(event -> {
                st.setFromValue(Color.KHAKI);
                st.setToValue(Color.DARKRED);
                st.setCycleCount(Animation.INDEFINITE);
                st.setAutoReverse(true);
                st.play();
            });
            setOnMouseExited(event -> {
                st.stop();
                bg.setFill(Color.DARKKHAKI);
            });
        }
    }

    private  static class MenuBox extends Pane {
        static SubMenu subMenu;
        public MenuBox(SubMenu subMenu){
            MenuBox.subMenu = subMenu;

            setVisible(false);
            Rectangle bg = new Rectangle(1024,768,Color.LIGHTBLUE);
            bg.setOpacity(0.15);
            getChildren().addAll(bg, subMenu);

            Label gameName = new Label("Виселеца");
            gameName.setFont(Font.font("Arial", FontPosture.ITALIC,80));
            gameName.setTextFill(Color.DARKRED);
            Reflection reflection = new Reflection();
            reflection.setFraction(0.4);
            reflection.setTopOffset(-20);
            gameName.setEffect(reflection);
            gameName.setTranslateX(500);
            gameName.setTranslateY(500);

            Label gamePost = new Label("Впрочем, жизнь вообще череда испытаний, и выживает сильнейший..." );
            gamePost.setFont(Font.font("Arial",FontWeight.BOLD, FontPosture.ITALIC,14));
            gamePost.setTextFill(Color.DARKGRAY);
            Reflection reflectionPost = new Reflection();
            reflectionPost.setFraction(0.6);
            reflectionPost.setTopOffset(0);
            gamePost.setEffect(reflectionPost);
            gamePost.setTranslateX(500);
            gamePost.setTranslateY(600);
            getChildren().addAll(gamePost);

            getChildren().addAll(gameName);
        }
        public void setSubMenu(SubMenu subMenu){
            getChildren().remove(MenuBox.subMenu);
            MenuBox.subMenu = subMenu;
            getChildren().add(MenuBox.subMenu);


            Label gamePost1 = new Label("Так стань же им!" );
            gamePost1.setFont(Font.font("Arial",FontWeight.BOLD, FontPosture.ITALIC,14));
            gamePost1.setTextFill(Color.DARKGRAY);
            Reflection reflectionPost = new Reflection();
            reflectionPost.setFraction(0.6);
            reflectionPost.setTopOffset(0);
            gamePost1.setEffect(reflectionPost);
            gamePost1.setTranslateX(500);
            gamePost1.setTranslateY(624);
            getChildren().addAll(gamePost1);
        }
    }

    private static class SubMenu extends VBox {
        public SubMenu(MenuItem... items){
            setTranslateX(412);
            setTranslateY(200);
            setSpacing(15);
            for(MenuItem item : items){
                getChildren().addAll(item);
            }

        }
    }

    private  void playAdio(String file) {
        try{
        File f = new File(file);
            if (playSoundOn) {

                Media hit = new Media(f.toURI().toString());
                mediaPlayer = new MediaPlayer(hit);
                mediaPlayer.play();
            }
            } catch(Exception ex) {
                ex.printStackTrace();
                System.out.println("Exception" + ex.getMessage());
            }

    }

    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();

        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");

        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }

    }
    private void stopAudio(){
        mediaPlayer.stop();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

