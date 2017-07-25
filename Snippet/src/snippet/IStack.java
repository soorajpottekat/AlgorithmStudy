/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snippet;

/**
 *
 * @author soorajpottekat
 */
interface IStack<Item>
{
    void push(Item item);
    Item pop();
    Item peek();
       
}
