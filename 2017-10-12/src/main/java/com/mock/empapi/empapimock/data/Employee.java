package com.mock.empapi.empapimock.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import lombok.Data;

import javax.imageio.*;
import javax.imageio.event.IIOReadWarningListener;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URL;
import java.util.Iterator;

@Data
public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String jobRole;
    private String department;
    private String email;
    private String phone;
    private String bankNumber;

    public Employee(Integer id) throws IOException {
        this.id = id;
    }

    @JsonIgnore
    public InputStream getImageFile() throws IOException {
        return Resources.getResource("img/employee" + id + ".jpg").openStream();
    }


    public Boolean isPortraitAvailable() {
        try {
            return getImageFile() != null;
        } catch (IOException e) {
            return  false;
        }
    }
}
