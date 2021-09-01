package com.wudaokou.easylearn.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "question")
public class Question implements Serializable {
    @PrimaryKey
    public int id;

    public String qAnswer;

    public String qBody;

    public boolean hasStar;

    public int totalCount;  // 该题训练次数

    public int wrongCount;  // 该题做错的次数
}
