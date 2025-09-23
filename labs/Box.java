package week6.labs;

class Box {
    public void pack() {
        System.out.println("Packing the box");
    }

    public void unpack() {
        System.out.println("Unpacking the box");
    }
}

class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack();
        System.out.println("Adding gift wrap");
    }

    @Override
    public void unpack() {
        super.unpack();
        System.out.println("Removing gift wrap");
    }

    public static void main(String[] args) {
        GiftBox gb = new GiftBox();
        gb.pack();
        gb.unpack();
    }
}
