public class Main {
    public static void main(String[] args) {
        var cd = new CD(
                new CD.FileSystemNode(
                        "Root",
                        new CD.FileSystemNode[] {
                                new CD.FileSystemNode("Nature sounds", CD.FileSystemNode.Extension.MP3),
                                new CD.FileSystemNode("White noise", CD.FileSystemNode.Extension.MP3),
                                new CD.FileSystemNode(
                                        "Metal",
                                        new CD.FileSystemNode[] {
                                                new CD.FileSystemNode("Life of Agony - Lost at 22", CD.FileSystemNode.Extension.MP3)
                                        })
                        }
                )
        );
    }
}

