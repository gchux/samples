/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine;

import java.io.IOException;
import java.util.Enumeration;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HandleTask extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try {
      response.setContentType("text/plain");
      final Enumeration headerNames = request.getHeaderNames();
      while( headerNames.hasMoreElements() ) {
        final String headerName = (String) headerNames.nextElement();
        System.out.println("headers[" + headerName + "]: " + request.getHeader(headerName));
      }
      final String key = request.getHeader("x-test-key");
      response.getWriter().println("OK: " + key);
    } catch(Exception e) {
      e.printStackTrace(System.out);
      response.getWriter().println("KO");
      return;
    }
  }
}
