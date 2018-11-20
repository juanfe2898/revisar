/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package searchmethods;

import java.util.ArrayList;
import java.util.Stack;


/**
 *
 * @author Tania V
 */
public class Dfs {
    
    public static void dfs_iterative(ArrayList<ArrayList<Integer>> path,int s ){
       boolean[] visited = new boolean[path.size()];
       Stack<Integer> pila = new Stack<>();
       pila.push(s);
       
       while(!pila.isEmpty()){
           int vertex = pila.pop();
           if(!visited[vertex]){
               visited[vertex] = true;
               System.out.println(vertex + " ");
               
               Stack<Integer> pilaTemp = new Stack<>();
               for(int index : path.get(vertex)){
                   if(!visited[index])
                       pilaTemp.push(index);   
               }
               while(!pilaTemp.isEmpty())
                    pila.push(pilaTemp.pop());
               
           }
       }
       System.out.println();
    }
    
    
    
    
    
    
    
}
