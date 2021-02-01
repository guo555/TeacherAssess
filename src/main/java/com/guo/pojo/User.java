package com.guo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String stu_num;
    private String username;
    private String tel;
    private String choice;
    private int stu_assess;
    private String stu_sg;

}
