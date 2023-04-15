package comands;

public abstract class Command implements Describable, Executable{
    private String name;
    private String description;
    private String argument = null;
    private boolean withArgument = false;
    private boolean withInput = false;

    public Command(String name, String description, boolean withArgument, boolean withInput){
        this.name = name;
        this.description = description;
        this.withArgument = withArgument;
        this.withInput = withInput;
    }

    public void setArgument(String argument){
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

    public boolean isWithArgument(){
        return withArgument;
    }

    public boolean isWithInput() {
        return withInput;
    }

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public String getDescription(){
        return this.description;
    }
}
