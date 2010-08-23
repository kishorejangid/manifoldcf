/* $Id$ */

/**
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements. See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.lcf.agents;

import org.apache.lcf.core.interfaces.*;
import org.apache.lcf.agents.interfaces.*;
import org.apache.lcf.agents.system.*;

/**
 * Use to unregister an agent by providing its class
 */
public class UnRegister extends BaseAgentsInitializationCommand
{
  public static final String _rcsid = "@(#)$Id$";

  private final String className;

  public UnRegister(String className)
  {
    this.className = className;
  }

  protected void doExecute(IThreadContext tc) throws LCFException
  {
    IAgentManager mgr = AgentManagerFactory.make(tc);
    mgr.unregisterAgent(className);
    Logging.root.info("Successfully unregistered agent '"+className+"'");
  }

  public static void main(String[] args)
  {
    if (args.length != 1)
    {
      System.err.println("Usage: UnRegister <classname>");
      System.exit(1);
    }

    String className = args[0];

    try
    {
      UnRegister unRegister = new UnRegister(className);
      unRegister.execute();
      System.err.println("Successfully unregistered agent '"+className+"'");
    }
    catch (LCFException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
