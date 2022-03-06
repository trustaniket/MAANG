import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3,3);
    }

    private Map<Integer, Node> nodeMap = new HashMap<>();
    private Map<Integer, DoublyLinkedList> frequencyDLLMap = new HashMap<>();
    private int minFrequency = 1;
    int capacity;

    public LFUCache(int capacity){
        this.capacity = capacity;
    }

    public void put(int key, int value){
        if(nodeMap.containsKey(key)){
            Node currNode = nodeMap.get(key);
            currNode.value = value;
            incrementFrequency(currNode);
            nodeMap.put(key, currNode);
        } else {
            Node newNode = new Node(key, value);
            if(this.capacity == nodeMap.size()){
                Node leastFreq = frequencyDLLMap.get(minFrequency).removeLast();
                nodeMap.remove(leastFreq.key);
                incrementFrequency(newNode);
                nodeMap.put(key, newNode);
            } else {
                incrementFrequency(newNode);
                nodeMap.put(key, newNode);
            }
            minFrequency = 1;
        }
    }

    public  int get(int key){
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            incrementFrequency(node);
            return node.value;
        } else {
            return -1;
        }
    }

    private void incrementFrequency(Node node){
        if(frequencyDLLMap.containsKey(node.frequency)){
            DoublyLinkedList oldDll = frequencyDLLMap.get(node.frequency);
            oldDll.remove(node);
            if(node.frequency == minFrequency && oldDll.length == 0){
                minFrequency += 1;
            }
        }

        int newFrequency = node.frequency + 1;
        node.frequency = newFrequency;

        DoublyLinkedList dll = frequencyDLLMap.getOrDefault(newFrequency, new DoublyLinkedList());
        dll.add(node);
        frequencyDLLMap.put(newFrequency , dll);
    }



    private class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            prev = next = null;
            frequency = 0;
        }
    }

    private class DoublyLinkedList {
        Node head;
        Node tail;
        int length;

        void add(Node node){
            node.next = null;
            node.prev = null;

            if(head == null){
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            length++;
        }

        void remove(Node node){
            if(node == head){
                if(node == tail){
                    tail = null;
                }
                head = head.next;
            } else {
                node.prev.next = node.next;
                if(node == tail){
                    tail = node.prev;
                } else {
                    node.next.prev = node.prev;
                }
            }
            length--;
        }

        Node removeLast(){
            Node tailNode = tail;
            if(tailNode != null){
                remove(tailNode);
            }
            return tailNode;
        }
    }
}
