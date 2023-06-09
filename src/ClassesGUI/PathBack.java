package ClassesGUI;

public enum PathBack {
    PATH_DESERTO1("src/ClassesGUI/ArquivosImagem/back_deserto1.jpeg"),
    PATH_DESERTO2("src/ClassesGUI/ArquivosImagem/back_deserto2.jpeg"),
    PATH_FLORESTA2("src/ClassesGUI/ArquivosImagem/back_floresta2.jpeg"),
    PATH_FLORESTA3("src/ClassesGUI/ArquivosImagem/back_floresta3.jpeg"),
    PATH_FLORESTA4("src/ClassesGUI/ArquivosImagem/back_floresta4.jpeg"),
    PATH_NEVE1("src/ClassesGUI/ArquivosImagem/back_neve1.jpeg"),
    PATH_NEVE3("src/ClassesGUI/ArquivosImagem/back_neve3.jpeg"),
    PATH_NEVE4("src/ClassesGUI/ArquivosImagem/back_neve4.jpeg");

    private final String img;

    PathBack (String img) {this.img = img;}

    public String getPath(){
        return img;
    }
}
