package com.csbot.tlou;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;

import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

import java.util.Scanner;

public class Bot {
    GatewayIntent[] gatewayIntents = new GatewayIntent[]{};
    String token;
    JDA jda;

    public Bot(String token) {
        this.token = token;
    }

    public void build(){
        
       //jdaBuilder.enableIntents(GatewayIntent.GUILD_MESSAGES,GatewayIntent.DIRECT_MESSAGES,gatewayIntents);
       JDABuilder jdaBuilder = JDABuilder.createLight(this.token,GatewayIntent.GUILD_MESSAGES,GatewayIntent.GUILD_MEMBERS,GatewayIntent.DIRECT_MESSAGES)
                    .addEventListeners(new DMevent())
                    .setActivity((Activity.playing("Vidya-games")));
                    
        //jdaBuilder.addEventListeners(new DMevent());
        //jdaBuilder.setActivity((Activity.playing("Stay/Night with your mom")));
        try {
            jda = jdaBuilder.build();
            jda.awaitReady();
            botInitialized();

        } catch (
                LoginException e) {
            e.printStackTrace();
        }
         catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void botInitialized(){
        Thread thread = new Thread(() ->{
            TextChannel textChannel = jda.getTextChannelById(754941074434293789L);
            while (true){
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                if (message != "" && message != "\n"&& message != null){
                    textChannel.sendMessage(message).queue();
                }
            }
        });
        thread.start();
    }
}
