//public class Rectange {
//    private int w,h;
//    private String color;
//
//    public Rectange(int h, int w, String color) {
//        this.w = w;
//        this.h = h;
//        String tmp=color;
//        this.color="";
//        this.color+=Character.toUpperCase(tmp.charAt(0));
//        for(int i=1;i<tmp.length();i++){
//            this.color+=Character.toLowerCase(tmp.charAt(i));
//        }
//    }
//
//    public Rectange() {
//        this.w=1;
//        this.h=1;
//    }
//
//    public int getW() {
//        return w;
//    }
//
//    public void setW(int w) {
//        this.w = w;
//    }
//
//    public int getH() {
//        return h;
//    }
//
//    public void setH(int h) {
//        this.h = h;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//    public int findArea(){
//        return w*h;
//    }
//    public int findPerimeter(){
//        return (w+h)*2;
//    }
//
//}