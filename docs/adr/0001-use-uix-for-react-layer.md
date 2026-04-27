# Use UIx for the React layer

Reagent is the more popular CLJS UI default, but it predates React hooks and adds friction when wrapping Radix primitives — which we'll be doing for accessible Dialog/Combobox/Popover. UIx is hooks-first, treats React as a first-class citizen, keeps Hiccup syntax (Helix doesn't), and has good shadow-cljs integration. Picked for clean Radix interop without giving up Hiccup readability.
