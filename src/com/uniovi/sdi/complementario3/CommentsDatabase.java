package com.uniovi.sdi.complementario3;

import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class CommentsDatabase {
	
	public List<Comment> getComments() {
        List<Comment> comments = new LinkedList<>();
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile("bdComments");
            List<Comment> respuesta = db.queryByExample(Comment.class);
            comments.addAll(respuesta);

        } finally {
            db.close();
        }
        return comments;
    }

    public void setNewComment(Comment comment) {
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile("bdComments");
            db.store(comment);
        } finally {
            db.close();
        }
    }
}
