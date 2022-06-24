package mx.edu.utez.aweb2.proyectobaseestructura2.utils;

public class ResultAction<T> {

    T obj;
    private String message;
    private String type;
    private boolean result;

    public ResultAction(T obj){
        this.obj=obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
