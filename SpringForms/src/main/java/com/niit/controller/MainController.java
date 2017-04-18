package com.niit.controller;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.TextFileDAO;
import com.niit.model.TextFile;

@Controller
public class MainController {
	
	@Autowired
	private TextFileDAO textFileDAO;
	
	@RequestMapping("/")
	public ModelAndView showHome()
	{
		ModelAndView mv=new ModelAndView("/Home");
		return mv;
	}
	
	@RequestMapping(value="/fileUpload",method = RequestMethod.POST)
	public ModelAndView uploadTextToDB(HttpServletRequest request, @RequestParam("FilePath") CommonsMultipartFile fileUpload) throws UnsupportedEncodingException
	{
		TextFile textFile=new TextFile();
		byte[] fileData=fileUpload.getBytes();
		StringBuilder strBuild=new StringBuilder();
		StringBuilder strReverse=new StringBuilder();
		String strO = new String(fileData , "UTF-8");
		textFile.setText(strO);
		char[] char1=strO.toCharArray();
		char[] ch2;
		for(int i=0;i<char1.length;i++)
		{
			if(Character.isWhitespace(char1[i]))
			{
				strReverse=strReverse.append(strBuild.reverse());
				strReverse=strReverse.append(" ");
				strBuild=new StringBuilder();
			}
			else
			{
				strBuild.append(char1[i]);
			}
		}
		strReverse=strReverse.append(strBuild.reverse());
		String reverse=new String(strReverse);
		textFile.setText(strO);
		textFile.setText_reverse(reverse);
		textFileDAO.save(textFile);
		ModelAndView mv=new ModelAndView("/Home");
		return mv;
	}

}
