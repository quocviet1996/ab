package com.example.didongdn.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nguoidung {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private Object name;
@SerializedName("username")
@Expose
private String username;
@SerializedName("email")
@Expose
private String email;
@SerializedName("password_digest")
@Expose
private String passwordDigest;
@SerializedName("created_at")
@Expose
private String createdAt;
@SerializedName("updated_at")
@Expose
private String updatedAt;
@SerializedName("avatar")
@Expose
private Avatar avatar;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public Object getName() {
return name;
}

public void setName(Object name) {
this.name = name;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPasswordDigest() {
return passwordDigest;
}

public void setPasswordDigest(String passwordDigest) {
this.passwordDigest = passwordDigest;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public String getUpdatedAt() {
return updatedAt;
}

public void setUpdatedAt(String updatedAt) {
this.updatedAt = updatedAt;
}

public Avatar getAvatar() {
return avatar;
}

public void setAvatar(Avatar avatar) {
this.avatar = avatar;
}

}