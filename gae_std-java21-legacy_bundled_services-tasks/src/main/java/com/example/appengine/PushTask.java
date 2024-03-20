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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

import java.util.concurrent.atomic.AtomicLong;

@WebServlet(name = "PushTask", value = "/task/push")
public class PushTask extends HttpServlet {

  private static final AtomicLong counter = new AtomicLong(0l);

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/plain");
    try {
      final long key = counter.incrementAndGet();
      final String keyStr = "task-" + key;
      Queue queue = QueueFactory.getQueue("gae-task-q");
      TaskOptions options = TaskOptions.Builder
        .withUrl("/task/handle")
        .param("key", keyStr)
        .header("x-test-key", keyStr)
        .method(TaskOptions.Method.POST);
      queue.add(options);
      System.out.println(keyStr);
      response.getWriter().println("OK: " + keyStr);
    } catch(Exception e) {
      e.printStackTrace(System.out);
      response.getWriter().println("OK");
    }
  }
}
