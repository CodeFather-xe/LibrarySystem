package SystemPackage;

import ItemsPackage.BorrowItem;
import ItemsPackage.Item;
import MemberPackage.Members;
import com.sun.source.tree.BreakTree;

import java.util.List;
import java.util.Scanner;

public class HelperClass {
  public static Scanner cin = new Scanner(System.in);
  static String tempStringInput;
  static int tempIntInput;

  // To Check if We have specified member in System
  static public Members checkMember(String name, List<Members> members) {
    for (Members member : members) {
      if (member.getName().equals(name)) {
        return member;
      }
    }
    return null;
  }

  // To Check if We have specified item in System, By ID or Specialization
  static public Item checkItem(String check, List<Item> items, String operation) {
    if (operation.equalsIgnoreCase("ID")) {
      for (Item item : items) {
        if (item.getId() == Integer.parseInt(check)) {
          return item;
        }
      }
    } else if (operation.equalsIgnoreCase("Specialization")) {
      for (Item item : items) {
        if (item.getSpecialization().equals(check)) {
          return item;
        }
      }
    }
    return null;
  }

  static public Item checkBorrowedItem(int id, List<BorrowItem> borrowItems) {
    for (BorrowItem x : borrowItems) {
      if (x.item.getId() == id) {
        return x.item;
      }
    }
    return null;
  }
    }