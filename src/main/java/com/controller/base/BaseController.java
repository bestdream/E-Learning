package com.controller.base;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.util.StringEscapeEditor;

public class BaseController
{
  @InitBinder
  public void initBinder(WebDataBinder binder)
  {
    binder.registerCustomEditor(String.class, new StringEscapeEditor());
  }
}