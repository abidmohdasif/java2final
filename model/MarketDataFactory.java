package com.portfolio.model;

import java.util.ArrayList;
import java.util.List;

public class MarketDataFactory {
    public static List<Company> createAllCompanies() {
        List<Company> list = new ArrayList<>();
        
        list.add(new Company("Zenith Energy", "ZENE", "Leader in fusion research and clean power.", 150.0, new BullMarketStrategy()));
        list.add(new Company("Aether Robotics", "AETH", "Developing AI-driven home bots for personal use.", 95.0, new VolatileStrategy()));
        list.add(new Company("Blue Marble Mining", "BLMM", "Pioneering asteroid extraction for rare metals.", 45.0, new VolatileStrategy()));
        list.add(new Company("CloudSync Global", "CSYG", "Dominating the decentralized cloud storage market.", 120.0, new BullMarketStrategy()));
        list.add(new Company("Vitality Pharm", "VITA", "Breakthrough in human longevity drug research.", 80.0, new VolatileStrategy()));
        list.add(new Company("Ironclad Security", "IRON", "Advanced cyber-defense systems for governments.", 65.0, new BullMarketStrategy()));
        list.add(new Company("Nova Media", "NOVA", "Next-gen streaming platform optimized for VR.", 30.0, new VolatileStrategy()));
        list.add(new Company("Quantum Compute", "QUAN", "Manufacturer of the world's fastest processors.", 210.0, new VolatileStrategy()));
        list.add(new Company("TerraForm Ag", "TERR", "Sustainable solutions for vertical indoor farming.", 55.0, new BullMarketStrategy()));
        list.add(new Company("Ocean Pulse", "OCNP", "Infrastructure projects for underwater city living.", 40.0, new VolatileStrategy()));
        list.add(new Company("Star-Link Logistics", "STRL", "Satellite-based freight and supply chain tracking.", 110.0, new BullMarketStrategy()));
        list.add(new Company("Apex FinTech", "APEX", "Secure blockchain-based retail banking solutions.", 90.0, new VolatileStrategy()));
        list.add(new Company("Hyperloop Transit", "HYPR", "High-speed vacuum rail transport technology.", 130.0, new BullMarketStrategy()));
        list.add(new Company("Synthesis Bio", "SYNB", "Custom-engineered synthetic organ manufacturing.", 75.0, new VolatileStrategy()));
        list.add(new Company("Ember Clean Power", "EMER", "Cutting-edge thermal energy storage systems.", 60.0, new BullMarketStrategy()));
        list.add(new Company("Orion Aerospace", "ORIA", "Commercial lunar cargo and exploration flights.", 160.0, new VolatileStrategy()));
        list.add(new Company("Core Logic Data", "CLOG", "Predictive analytics for enterprise decision-making.", 50.0, new BullMarketStrategy()));
        list.add(new Company("Deep Blue Seafood", "DEEP", "Sustainable open-ocean aquaculture farms.", 35.0, new VolatileStrategy()));
        list.add(new Company("Titan Construction", "TITN", "Automated 3D-printing technology for skyscrapers.", 100.0, new BullMarketStrategy()));
        list.add(new Company("Zenith Telematics", "ZTEL", "Global real-time fleet management software.", 45.0, new VolatileStrategy()));
        list.add(new Company("Paradigm Gaming", "PARA", "Immersive, neural-link enabled virtual reality.", 25.0, new VolatileStrategy()));
        list.add(new Company("Solara Panels", "SOLA", "Transparent glass panels with integrated solar cells.", 70.0, new BullMarketStrategy()));
        list.add(new Company("Vector Motors", "VECT", "Self-driving electric commercial vehicle fleets.", 140.0, new VolatileStrategy()));
        list.add(new Company("Nexus Social", "NEXU", "AR-focused social networking and interaction.", 50.0, new BullMarketStrategy()));
        list.add(new Company("Chronos Health", "CHRO", "Predictive genetic mapping for disease prevention.", 95.0, new VolatileStrategy()));
        
        return list;
    }
}