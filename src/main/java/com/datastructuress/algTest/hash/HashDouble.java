package com.datastructuress.algTest.hash;

/**
 * @author dongyl
 * @date 18:39 12/28/17
 * @project study-demo
 */
public class HashDouble {

    public  void test() {
        HashTable hashTable = new HashTable(5);
        DataItem item = new DataItem(5);
        hashTable.insert(3,item);
        hashTable.displayTable();
    }

    class HashTable {
        private DataItem[] hashArray;
        private int arraySize;
        private DataItem nonItem;

        public HashTable(int size) {
            arraySize = size;
            hashArray = new DataItem[arraySize];
            nonItem = new DataItem(-1);

        }

        public void displayTable() {
            System.out.println("Table :");
            for (int i = 0; i < arraySize; i++) {
                if (hashArray[i] != null) {
                    System.out.print(hashArray[i].getiData() + " ");
                } else {
                    System.out.print("** ");
                }
            }
            System.out.println(" ");
        }

        public int hashFunc1(int key) {
            return key % arraySize;
        }

        public int hashFunc2(int key) {
            return 5 - key % 5;
        }

        public void insert(int key, DataItem item) {
            int hashVal = hashFunc1(key);
            int stepSize = hashFunc2(key);
            while (hashArray[hashVal] != null || hashArray[hashVal].getiData() != -1) {
                hashVal += stepSize;
                hashVal %= arraySize;
                hashArray[hashVal] = item;
            }
        }
    }

    class DataItem {
        private int iData;

        public DataItem(int iData) {
            this.iData = iData;
        }

        public int getiData() {
            return iData;
        }

        public void setiData(int iData) {
            this.iData = iData;
        }
    }
}
