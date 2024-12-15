package kr.ac.seoil.front.board.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private int rn;
	private Long bno;
	private String title;
	private String content;
	private String writerNm;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date regDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date modDate;
}
