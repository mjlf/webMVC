package com.mjlf.MVC.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by a123 on 17/6/14.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,
reason = "don't have this information")
public class MyNotFoundException extends RuntimeException {
}
