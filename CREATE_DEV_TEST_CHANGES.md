# Create dev compatibility test variant

This source tree is a test variant for a Create 1.20.1/dev build that already contains the late 2025 upstream fixes and a native JourneyMap API 2.0 train-map integration.

Removed from Create Repair for this test:

- `client/compat/journeymap/RepairedJourneyTrainMap.java` — prevents Create Repair from registering its own JourneyMap API 2.0 train-map renderer.
- `bug_fixes.handle_rotation.HandCrankBlockEntityMixin`
- `bug_fixes.handle_rotation.ValveHandleBlockEntityMixin`
- `client.bug_fixes.handle_rotation.HandCrankAndValveVisualMixin`
- `client.bug_fixes.handle_rotation.HandCrankRendererMixin`
  - these backport Create PR #8828 / commit `5881242`, already present in the tested Create dev build.
- `resourcepacks/create_repair_asset_overrides/assets/create/models/block/ladder.json`
  - this backports Create commit `25c625d` (No shade for ladders), already present in the tested Create dev build.

The Create Repair mod itself, including mod id `create_repair`, remains present. Other fixes are unchanged. This is intentional so the test can determine whether JourneyMap 6's Create compatibility gate is satisfied merely by Create Repair being installed while the train-map implementation comes from Create itself.
