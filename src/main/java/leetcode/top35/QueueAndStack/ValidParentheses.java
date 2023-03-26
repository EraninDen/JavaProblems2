package leetcode.top35.QueueAndStack;

import java.util.*;

public class ValidParentheses {

    public boolean isValid(String s) {
        // Create a new stack to store the characters.
        Stack<Character> stack = new Stack<>();
        // convert string into char array and access the characters using for each loop.
        for (char ch : s.toCharArray()) {
            // check ch
            switch (ch) {
                // open bracket then push it in stack.
                // close bracket then pop the item and compare.
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                    // if the stack is empty then it means string have no open bracket.
                    // hence it is invalid.
                    {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        // After the loop we have to check one more condition.
        // return true only if the stack is empty.
        // if stack is not empty that means we have unused brackets.
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public boolean isValid3(String s) {
        // Create hashmap to store the pairs...
        HashMap<Character, Character> Hmap = new HashMap<Character, Character>();
        Hmap.put(')', '(');
        Hmap.put('}', '{');
        Hmap.put(']', '[');
        // Create stack data structure...
        Stack<Character> stack = new Stack<Character>();
        // Traverse each charater in input string...
        for (int idx = 0; idx < s.length(); idx++) {
            // If open parentheses are present, push it to stack...
            if (s.charAt(idx) == '(' || s.charAt(idx) == '{' || s.charAt(idx) == '[') {
                stack.push(s.charAt(idx));
                continue;
            }
            // If the character is closing parentheses, check that the same type opening parentheses is being pushed to the stack or not...
            // If not, we need to return false...
            if (stack.size() == 0 || Hmap.get(s.charAt(idx)) != stack.pop()) {
                return false;
            }
        }
        // If the stack is empty, return true...
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isValid4(String s) {

        List<Character> open = Arrays.asList('(', '{', '[');
        List<Character> close = Arrays.asList(')', '}', ']');
        Queue<Character> qu = Collections.asLifoQueue(new LinkedList<Character>());
        int op = 0;
        int cl = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (open.contains(c)) {
                op++;
                int idx = open.indexOf(c);
                qu.add(close.get(idx));
            } else if (close.contains(c)) {
                if (qu.size() == 0)
                    return false;
                cl++;
                char cc = qu.poll();
                if (cc != c)
                    return false;
            }
        }
        return op == cl;
    }

    Queue<Character> q = new LinkedList<>();
    Map<Character, Character> map = new HashMap<>();
    public boolean isValid5(String s) {

        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        char[] chs = s.toCharArray();
        for(char c : chs){
            q.offer(c);
        }

        return helper('x');
    }
    public boolean helper(char c){
        char curr = 'x';
        while(q.size() > 0){
            curr = q.poll();

            if(curr == '[' || curr == '(' || curr == '{'){
                if(helper(curr) == false)
                    return false;

                curr = 'x';
            }else if(c == map.get(curr)){
                return true;
            }
            else return false;
        }
        //this one handle the special case when the length is odd and you try to pair up for last
        // element and it actully skip the loop when queue's size = 0, but curr is default to x, so we also need to check
        // c's value in this case, and first call in main function also set to 'x'. for them to pair up and match at the end.
        // if(c!='x')
        //     return false;
        // return curr == 'x' ? true : false;  when everything get pair up it become x again.

        // the most important line is here that, when current round q.size() = 0, but c = '[' or '(' or '{'
        // so we need to return false, if we only check curr where will get reset to x again if recursion return true;
        // however, give case that is odd length like '[' we are trying to looking for ']' but we actully skip the loop
        // since the size of queue = 0 and only checking curr is not always cover and show everything pair up.
        return c == curr;
    }

    Map<Character, Character> mp = new HashMap<>();

    public boolean isValid6(String s) {
        mp.put(']','[');
        mp.put(')','(');
        mp.put('}','{');
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '['  || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.size()!=0){
                    char ch = stack.peek();
                    if(ch == mp.get(s.charAt(i))) stack.pop();
                    else
                        return false;
                }
                else{
                    return false;
                }

            }
        }
        return stack.size()==0;
    }
}
