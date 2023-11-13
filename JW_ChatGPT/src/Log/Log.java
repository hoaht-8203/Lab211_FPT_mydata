/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Log;

/**
 *
 * @author hoaht
 */
public class Log {
    private String input;
    private int type;
    private String output;
    private String topic;

    public Log() {
    }

    public Log(String input, int type, String output, String topic) {
        this.input = input;
        this.type = type;
        this.output = output;
        this.topic = topic;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Log{" + "input=" + input + ", type=" + type + ", output=" + output + ", topic=" + topic + '}';
    }
}
