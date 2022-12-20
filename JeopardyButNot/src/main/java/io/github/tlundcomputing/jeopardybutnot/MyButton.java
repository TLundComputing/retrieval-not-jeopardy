package io.github.tlundcomputing.jeopardybutnot;

import javafx.scene.control.Button;

public class MyButton extends Button {

    private String[] states;
    private int stateNum;

    public MyButton(String[] questionStructure){
        super();
        states = questionStructure;
        stateNum = 0;
        this.setText(states[stateNum]);
    }

    public void processClick(){
        stateNum ++;
        switch (stateNum) {
            case 1 -> this.setText(states[stateNum]);
            case 2 -> {
                this.setText(states[stateNum]);
                this.setDisable(true);
            }
            default -> this.setDisable(true);
        }
    }

}
