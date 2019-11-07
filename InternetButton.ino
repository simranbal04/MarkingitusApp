// This #include statement was automatically added by the Particle IDE.
#include <InternetButton.h>

// Make an InternetButton object 
InternetButton button = InternetButton();

void setup() 
{
    button.begin();
    
    Particle.function("Time",second);
    
    for  ( int i = 0; i < 3; i++)
  {
      button.allLedsOn(255,0,0);
      delay(250);
      button.allLedsOff();
      delay(250);
  }


}

int DELAY = 1000;
int second(String cmd)
{
    int sec = cmd.toInt();
    // if(sec>0 && sec<6)
    if(sec == 0)
    {
        // button.ledOff(11);
      button.ledOn(1,165,42,42);  
      button.ledOn(11,165,42,42);
      for( int i = 3; i <= 9; i++)
      {
          button.ledOn(i,165,42,42);
          
    //   button.ledOn(4,165,42,42);
      }
      delay(DELAY);
      
      // to turn off all the leds
      button.allLedsOff();
      delay(DELAY);
      
    }
    if(sec>=1 && sec<=4)
    {
        // button.ledOff(3);
        // button.ledOff(9);
        button.ledOn(1,201,255,229);  
      button.ledOn(11,201,255,229);
        for(int i = 4; i <= 8; i++)
        {
            button.ledOn(i,201,255,229);
        }
        delay(DELAY);
            button.allLedsOff();
      delay(DELAY);
      
    }
    if(sec>=5 && sec<=9)
    {
         button.ledOn(1,196,98,16);   
         button.ledOn(11,196,98,16);
         for(int i = 5; i <= 7; i++)
        {
            button.ledOn(i,196,98,16);
        }
            delay(DELAY);
            button.allLedsOff();
      delay(DELAY);
    //   delay(DELAY);
           
    }
    
    if(sec>=10 && sec<=14)
    {
         button.ledOn(1,59,122,87);  
         button.ledOn(11,59,122,87);
         button.ledOn(6,59,122,87);
        //  for(int i = 6; i <= 6; i++)
        // {
        //     button.ledOn(i,201,255,229);
        // }
            delay(DELAY);
            button.allLedsOff();
      delay(DELAY);
    //   delay(DELAY);
           
    }
     if(sec>=15 && sec<=19)
    {
         button.ledOn(1,0,48,143);   
         button.ledOn(11,0,48,143);
        //  button.ledOn(6,201,255,229);
        
       delay(DELAY);
            button.allLedsOff();
      delay(DELAY);
    //   delay(DELAY);
    }
    
    if(sec == 20)
    {
        button.allLedsOn(255,0,0);
        
        delay(DELAY);
            button.allLedsOff();
      delay(DELAY);
    //   delay(DELAY);
    }


}
void loop() {

}

