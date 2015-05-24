/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Diosio
 */
public class Video {
    int idVideo;
    String pathVideo;
    int idProductoVideo;
    boolean activoVideo;

    public Video(int idVideo, String pathVideo, int idProductoVideo, boolean activoVideo) {
        this.idVideo = idVideo;
        this.pathVideo = pathVideo;
        this.idProductoVideo = idProductoVideo;
        this.activoVideo = activoVideo;
    }
    
     public Video( String pathVideo, int idProductoVideo, boolean activoVideo) {
       
        this.pathVideo = pathVideo;
        this.idProductoVideo = idProductoVideo;
        this.activoVideo = activoVideo;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public String getPathVideo() {
        return pathVideo;
    }

    public void setPathVideo(String pathVideo) {
        this.pathVideo = pathVideo;
    }

    public int getIdProductoVideo() {
        return idProductoVideo;
    }

    public void setIdProductoVideo(int idProductoVideo) {
        this.idProductoVideo = idProductoVideo;
    }

    public boolean isActivoVideo() {
        return activoVideo;
    }

    public void setActivoVideo(boolean activoVideo) {
        this.activoVideo = activoVideo;
    }
    
    
    
}
