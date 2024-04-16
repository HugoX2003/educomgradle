package com.project.educom.Models;

public class Comentario {
    private String comment;
    private Usuario user;

    public Comentario(String comment, Usuario user) {
        this.comment = comment;
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
