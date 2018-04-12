package FightKnights.Logic;

import FightKnights.Classes.*;

public class Unit 
{
	private String name;
	private int cost;
	private int damage;
	private int health;
        private String type;
        private String state;
        private boolean attackExecuted;
	// LAS UNIDADES SE CREAN AL INICIAR LA PARTIDA Y SE METEN AL ARRAY DE CADA JUGADOR
	
	public Unit(String name_unit)
	{
		switch(name_unit)
		{
			case "Contramaestre":
			{
				Contramaestre contramaestre = new Contramaestre();
				this.name = contramaestre.getName();
				this.cost = contramaestre.getCost();
				this.damage = contramaestre.getDamage();
				this.health = contramaestre.getHealth();
                                this.type = contramaestre.getType();
			}
                        
                        case "Caballero Sagrado":
                        {
                                CaballeroSagrado caballero_sagrado = new CaballeroSagrado();
                                this.name = caballero_sagrado.getName();
                                this.cost = caballero_sagrado.getCost();
                                this.damage = caballero_sagrado.getDamage();
                                this.health = caballero_sagrado.getHealth();
                                this.type = caballero_sagrado.getType();
                        }
                        
                        case "Bola de Fuego":
                        {
                                BolaDeFuego bola_de_fuego = new BolaDeFuego();
                                this.name= bola_de_fuego.getName();
                                this.cost = bola_de_fuego.getCost();
                                this.damage = bola_de_fuego.getDamage();
                                this.health = bola_de_fuego.getHealth();
                                this.type = bola_de_fuego.getType();
                        }
                        
                        case "Acechador Oscuro":
                        {
                                AcechadorOscuro acechador_oscuro = new AcechadorOscuro();
                                this.name= acechador_oscuro.getName();
                                this.cost = acechador_oscuro.getCost();
                                this.damage = acechador_oscuro.getDamage();
                                this.health = acechador_oscuro.getHealth();
                                this.type = acechador_oscuro.getType();
                        }
                        
                        case "Cazador":
                        {
                                Cazador cazador = new Cazador();
                                this.name= cazador.getName();
                                this.cost = cazador.getCost();
                                this.damage = cazador.getDamage();
                                this.health = cazador.getHealth();
                                this.type = cazador.getType();
                        }
		}
	}
	
	// AL CREAR LA UNIDAD SE EJECUTA INITSKILL Y ALIVESKILL PARA COMPROBAR
	// SI ESA CARTA TIENE EFECTOS DE ESOS.
	
	public void initSkill(Unit target) // Efecto que se ejecuta al invocar la carta.
	{
		switch(name)
		{
                    case "Bola de fuego":
                    {
                        target.setHealth(target.getHealth() - damage);
                    }
                    case "Caballero Sagrado":
                    {
                        state = "Guard"; //estado de "Provocar"
                    }
                    case "Acechador Oscuro":
                    {
                        state = "Sentence"; //mata al enemigo directamente
                    }
                    case "Cazador":
                    {
                        Match match = Match.getMatchInstance();
                        Unit lobo = new Unit("Lobo");
                        //GameMethods.invokeCard(lobo, null, match.getP_turn());
                        if(match.getP_turn()==1)
                        {
                            if(match.getP1_table().size()<2)
                            {
                                match.getP1_table().add(lobo);
                                match.getP1_table().add(lobo);
                            }
                            if(match.getP1_table().size()<3)
                            {
                                match.getP1_table().add(lobo);                                
                            }
                            if(match.getP1_table().size()<4)
                            {
                                System.out.println("No cabe ninguna carta");                                
                            }
                            
                        }
                        else
                        {
                            if(match.getP2_table().size()<2)
                            {
                                match.getP2_table().add(lobo);
                                match.getP2_table().add(lobo);
                            }
                            if(match.getP2_table().size()<3)
                            {
                                match.getP2_table().add(lobo);                                
                            }
                            if(match.getP2_table().size()<4)
                            {
                                System.out.println("No cabe ninguna carta");                                
                            }
                        }
                    }
		}
	}
	
	public void attackSkill(Unit target) // Efecto que se ejecuta al atacar.
	{
		switch(name)
		{
                    
		}
	}
	
	public void aliveSkill(Unit target) // Efecto que se ejecuta mientras esta en la mesa.
	{
		switch(name)
		{
                    
		}
	}
	
	public void deathSkill(Unit target) // Efecto que se ejecuta al ser destruda la carta.
	{
		switch(name)
		{
			case "Contramaestre":
			{
				Unit bolaFuego = new Unit("Bola de Fuego");
                                bolaFuego.initSkill(target);
			}
		}
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getCost()
	{
		return cost;
	}
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	public int getDamage()
	{
		return damage;
	}
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int health)
	{
		this.health = health;
	}
        public String getType() 
        {
                return type;
        }

        public void setType(String type) 
        {
                this.type = type;
        }

        public String getState() 
        {
                return state;
        }

        public void setState(String state) 
        {
                this.state = state;
        }

        public boolean isAttackExecuted() {
            return attackExecuted;
        }

        public void setAttackExecuted(boolean attackExecuted) {
            this.attackExecuted = attackExecuted;
        }
        
}