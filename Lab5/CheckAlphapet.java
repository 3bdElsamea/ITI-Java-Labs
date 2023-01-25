class CheckAlphapet {

    public static boolean onlyAlphabets(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        if (args.length == 1) {
            if (onlyAlphabets(args[0])) {
                System.out.println("String Contains Only Alphapets");
            } else {
                System.out.println("String Contains non Alphapet");
            }
        } else {
            System.out.println("Please Enter an Argument to Check");
        }
    }
}
