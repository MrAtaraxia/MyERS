
import { Greeting } from "./hello";
export class Dog{
    private _height:number;
    private _name:string;
    constructor(name){
        console.log("Make a dog");
        this._name=name;
    }
    speak(){
        console.log(this._name);
    }
}

let greet = Greeting;
