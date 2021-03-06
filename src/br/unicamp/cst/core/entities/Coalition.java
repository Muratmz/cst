/*******************************************************************************
 * Copyright (c) 2012  DCA-FEEC-UNICAMP
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 * 
 * Contributors:
 *     K. Raizer, A. L. O. Paraense, R. R. Gudwin - initial API and implementation
 ******************************************************************************/

package br.unicamp.cst.core.entities;

import java.util.List;

/**
 * A Coalition is a group of Codelets which are gathered in order to perform a task
 * by summing up their abilities or to form a specific context.
 * 
 * Two codelets belong to the same coalition when they share information - pragmatically, 
 * when they write in and read from the same memory object 
 * 
 * @author andre.paraense
 * @author klaus.raizer
 */
public class Coalition
{
   
   /**
    * List of all Codelets in this Coalition
    */
   private List<Codelet> codeletsList;
   
   /**
    * This Coalition's activation
    */
   private double activation;
   
   /**
    * 
    * @param codeletsList
    */
   public Coalition(List<Codelet> codeletsList)
   {
      this.codeletsList = codeletsList;
      this.activation = calculateActivation();
   }

   /**
    * 
    * @return
    */
   public double calculateActivation()
   {
      double activation = 0.0;
      if(codeletsList!=null&&codeletsList.size()>0)
      {
         for(Codelet codelet : codeletsList)
         {
            activation+=codelet.getActivation();
         }
         activation/=codeletsList.size();
      }
      return activation;
   }
   
   /**
    * @return the codeletsList
    */
   public List<Codelet> getCodeletsList()
   {
      return codeletsList;
   }

   
   /**
    * @param codeletsList the codeletsList to set
    */
   public void setCodeletsList(List<Codelet> codeletsList)
   {
      this.codeletsList = codeletsList;
   }
   
   /**
    * @return the activation
    */
   public double getActivation()
   {
      return activation;
   }

   
   /**
    * @param activation the activation to set
    */
   public void setActivation(double activation)
   {
      this.activation = activation;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      final int maxLen = 10;
      return "Coalition [activation=" + activation + ", " + (codeletsList != null ? "codeletsList=" + codeletsList.subList(0, Math.min(codeletsList.size(), maxLen)) : "") + "]";
   }
   
}
