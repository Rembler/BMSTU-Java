public class Mobile {
    public String name;
    public Specifications specifications;

    public Mobile(String name, Specifications specifications) {
        this.name = name;
        this.specifications = specifications;
    }

    public static class Specifications {
        public String operatingSystem;
        public boolean hasCardSlot;
        public boolean supportsNFC;
        public int numberOfCPUCores;
        public double cpuFrequency;

        public Specifications(
                String operatingSystem,
                boolean hasCardSlot,
                boolean supportsNFC,
                int numberOfCPUCores,
                double cpuFrequency
        ) {
            this.operatingSystem = operatingSystem;
            this.hasCardSlot = hasCardSlot;
            this.supportsNFC = supportsNFC;
            this.numberOfCPUCores = numberOfCPUCores;
            this.cpuFrequency = cpuFrequency;
        }
    }
}
