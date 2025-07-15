package com.shop.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public String handleMaxSizeException(Model model) {
    model.addAttribute("errorMessage", "파일 크기가 제한을 초과하였습니다. 최대 20MB까지만 가능합니다.");
    return "item/itemForm";
  }

}
