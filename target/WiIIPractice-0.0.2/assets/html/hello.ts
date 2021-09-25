let message:string="hello";

console.log(message);


export class Greeting{

    name:string;
    constructor (name) {
        this.name=name;
    }
    
    greet():string
    {
        console.log("Hello" + this.name);
        return "Hello, " + this.name;
    }
}
let greeter = new Greeting("Bob");
greeter.greet