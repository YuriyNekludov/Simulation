# 2D SIMULATION
<sup>Herbivores and Predators</sup>

## Overview

This Java project is a 2D simulation involving two types of creatures: herbivores and predators. In this simulation, 
predators hunt herbivores, herbivores consume grass, and various dynamics affect their health and damage. 
The movement is entirely automated, allowing users to observe the creatures' interactions on the map.

## Features

- **Creature Types:**
    - Herbivores: Consume grass for sustenance. Designs: Cow, Zebra, Elephant.
    - Predators: Hunt herbivores. Designs: Crocodile, Wolf, Tiger.

- **Automated Movement:**
    - Creatures move autonomously based on predefined behavioral patterns.

- **Endurance System:**
    - Creatures have endurance that determines the number of steps they can take in each turn.

- **Simulation Dynamics:**
    - Predators hunt herbivores.
    - Herbivores graze on grass.
    - Endurance influences the distance creatures can cover.

- **Static Objects:**
    - Trees and rocks added as static objects on the map.
    - Creatures cannot step on trees and rocks.

- **Creature Designs:**
    - Creature appearance depends on their endurance.
    - Herbivores: Cow, Zebra, Elephant.
    - Predators: Crocodile, Wolf, Tiger.

- **Damage Variation:**
    - Predator damage varies based on endurance.
    - Crocodile inflicts less damage than Wolf.
    - Wolf inflicts less damage than Tiger.

- **Hunger Mechanics:**
    - Creatures face starvation if they cannot find food for a certain number of turns.
    - Starving creatures perish.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/YuriyNekludov/Simulation.git
   ```
   
2. Open the project in your preferred IDE.
3. Run the simulation.

### Usage

1. Launch the simulation.
2. Observe the interactions between herbivores and predators.
3. Creatures will move autonomously based on their behavior, endurance, and design.
They will avoid static objects such as trees and rocks.