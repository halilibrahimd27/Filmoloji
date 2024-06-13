/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author semih
 */
public class TrenddekiDiziler {

    private FilmveDizi fd;
    

    public TrenddekiDiziler() {
    }

    public FilmveDizi getFd() {
        if (fd == null) {
            fd = new FilmveDizi();
        }
        return fd;
    }

    public void setFd(FilmveDizi fd) {
        this.fd = fd;
    }

}
