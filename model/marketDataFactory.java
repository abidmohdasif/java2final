package com.portfolio.model;

import java.util.ArrayList;
import java.util.List;

public class MarketDataFactory {
    public static List<Company> createAllCompanies() {
        List<Company> companies = new ArrayList<>();
        
        // Using a basic strategy for all, or mix and match them!
        PriceUpdateStrategy steady = new BullMarketStrategy();
        PriceUpdateStrategy volatileStr = new VolatileStrategy();

        companies.add(new Company("Zenith Energy", 150.0, steady));
        companies.add(new Company("Aether Robotics", 95.0, volatileStr));
        companies.add(new Company("Blue Marble Mining", 45.0, volatileStr));
        companies.add(new Company("CloudSync Global", 120.0, steady));
        companies.add(new Company("Vitality Pharm", 80.0, volatileStr));
        companies.add(new Company("Ironclad Security", 65.0, steady));
        companies.add(new Company("Nova Media", 30.0, volatileStr));
        companies.add(new Company("Quantum Compute", 210.0, volatileStr));
        companies.add(new Company("TerraForm Ag", 55.0, steady));
        companies.add(new Company("Ocean Pulse", 40.0, volatileStr));
        companies.add(new Company("Star-Link Logistics", 110.0, steady));
        companies.add(new Company("Apex FinTech", 90.0, volatileStr));
        companies.add(new Company("Hyperloop Transit", 130.0, steady));
        companies.add(new Company("Synthesis Bio", 75.0, volatileStr));
        companies.add(new Company("Ember Clean Power", 60.0, steady));
        companies.add(new Company("Orion Aerospace", 160.0, volatileStr));
        companies.add(new Company("Core Logic Data", 50.0, steady));
        companies.add(new Company("Deep Blue Seafood", 35.0, volatileStr));
        companies.add(new Company("Titan Construction", 100.0, steady));
        companies.add(new Company("Zenith Telematics", 45.0, volatileStr));
        companies.add(new Company("Paradigm Gaming", 25.0, volatileStr));
        companies.add(new Company("Solara Panels", 70.0, steady));
        companies.add(new Company("Vector Motors", 140.0, volatileStr));
        companies.add(new Company("Nexus Social", 50.0, steady));
        companies.add(new Company("Chronos Health", 95.0, volatileStr));
        
        return companies;
    }
}