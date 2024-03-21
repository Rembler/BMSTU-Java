public class CD {
    public FileSystemNode rootNode;
    
    public CD(FileSystemNode rootNode) {
        this.rootNode = rootNode;
    }
    
    public static class FileSystemNode {
        public String name;
        public Extension extension;
        public FileSystemNode[] childNodes;

        public FileSystemNode(String name, FileSystemNode[] childNodes) {
            this.name = name;
            this.extension = Extension.None;
            this.childNodes = childNodes;
        }

        public FileSystemNode(String name, Extension extension) {
            this.name = name;
            this.extension = extension;
            this.childNodes = new FileSystemNode[] {};
        }

        public enum Extension {
            None,
            MP3
        }
    }
}
