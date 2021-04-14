package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "author"})
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    @NotBlank(message = "Поле 'текст' должно быть  заполнено!")
    @Length(max = 2048, message = "Сообщение не должен превышать 2048 символов!")
    private String text;

    @Column(name = "tag")
    @Length(max = 255, message = "Тэн не должен превышать 255 символов!")
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users author;

    private String filename;
}
